*** Settings ***
Resource           ../pages/AutorizationLogin.robot
Resource           ../pages/AutorizationToken.robot

*** Variables ***
${NAME_PROGRESSBAR}   xpath=//div[@role='progressbar']

*** Keyword ***
To Console
    [Arguments]      ${text}
    IF  '${LogToConsole}' == 'True'
         Log To Console   ${text}
    END

Open Browser To Login Page Admin And Connect To Database
    Open Browser   ${url.autorization}   ${browser}   options=add_argument("--ignore-certificate-errors"); add_argument("--start-maximized"); add_experimental_option("excludeSwitches", ["enable-automation"]); add_experimental_option("useAutomationExtension", "false")
    Go To          ${url.autorization}
    Input Login And Password   ${admin.login}   ${admin.password}
    Input Token                ${admin.token}
    Choice Mode ADMIN
    Connect To Database        ${db.driver}   ${db.name}   ${db.username}   ${db.password}   ${db.url}   ${db.port}

Close Browser End Suite
    Disconnect From Database
    Sleep  1
    Close Browser

Click If Visible Element
    [Arguments]        ${element}
    ${status}=  Run Keyword And Return Status   Element Should Be Visible   ${element}
    IF  '${status}' == 'True'
         Click Element  ${element}
    END
    RETURN  ${status}

Wait Is Visible Element And Click
    [Arguments]                        ${element}
    Wait Until Element Is Visible      ${element}   ${wait}
    Click Element                      ${element}

Wait Is Visible Element And Input Text
    [Arguments]                        ${element}   ${text}
    Wait Until Element Is Visible      ${element}   ${wait}
    Input Text                         ${element}   ${text}

Input Empty Text
    [Arguments]                        ${element}
    Wait Until Element Is Visible      ${element}   ${wait}
# https://www.selenium.dev/selenium/docs/api/py/webdriver/selenium.webdriver.common.keys.html#selenium.webdriver.common.keys.Keys.CONTROL
    Press Keys   ${element}   HOME
    Press Keys   None         SHIFT+END
    Press Keys   None         DELETE

Wait Download Page
    Sleep   1
    TRY
        Wait Until Element Is Visible       ${NAME_PROGRESSBAR}   1
    EXCEPT
        To Console  EXCEPT - NAME_PROGRESSBAR not
    END
    ${status}=  Run Keyword And Return Status   Element Should Be Visible   ${NAME_PROGRESSBAR}
    IF  '${status}' == 'True'
         Wait Until Element Is Not Visible   ${NAME_PROGRESSBAR}   ${wait}
    END

Get API ID Group New Name Group AutoTest
    [Arguments]         ${group}
    ${filter}=          Create Dictionary   filter=${new.name.group}
    ${searchFilter}=    Create Dictionary   filter=${filter}
    ${body}=            Evaluate   json.dumps(${searchFilter})   json    # переводит одинарные в двойные ковычки
    ${header}=          Create Dictionary   Content-Type=application/json
    #To Console  ${body} - ${header}
    Create Session   SessionGroup   ${url.base.api}   disable_warnings=1
    ${response}=     POST On Session   SessionGroup   /admin/${group}/group/search/simple   data=${body}   headers=${header}
    Should Be Equal As Integers   ${response.status_code}   200
    TRY
        ${id}=   Get Value From Json   ${response.json()}   $.data[*].id
        ${id}=   Set Variable    ${id[0]}
    EXCEPT
        RETURN   0
    ELSE
        RETURN   ${id}
    END

Delete API ID Group New Name Group AutoTest
    [Arguments]          ${group}   ${id}
    IF  '${id}' != ''
        Create Session  SessionDEL   ${url.base.api}   disable_warnings=1
        ${response}=    DELETE On Session   SessionDEL   /admin/${group}/group/${id}
        Should Be Equal As Integers    ${response.status_code}   204
    END


Get BD ID Group New Name Group AutoTest
    [Arguments]   ${group}
    @{output} =   Query   select id from ${group}_group where name='${new.name.group}'
    ${id}=        Set Variable   ${output[0][0]}
    RETURN   ${id}

Get Data is API And DB Comparison And Delete
    [Arguments]   ${group}
    To Console  Get API ID Group
    ${idApi}=   Get API ID Group New Name Group AutoTest   ${group}
    Should Not Be Equal  '${idApi}'   ''

    To Console  Get BD ID Group
    ${idDB}=   Get BD ID Group New Name Group AutoTest   ${group}
    Should Not Be Equal  '${idDB}'   ''

    To Console         ${idApi} - ${idDB}
    Should Be Equal   '${idApi}'   '${idDB}'

    To Console  Delete API ID Group -> ${idApi}
    Delete API ID Group New Name Group AutoTest   ${group}   ${idApi}

    To Console  Get API ID Group
    ${idApi}=   Get API ID Group New Name Group AutoTest   ${group}
    Should Be Equal  '${idApi}'   '0'