*** Variables ***
${inputUserLogin}           name=username
${inputUserPassword}        name=password
${buttonSubmit}             name=submit

*** Keyword ***
Input Login And Password
    [Arguments]    ${login}    ${password}
    Wait Until Element Is Visible         ${buttonSubmit}
    Input Text     ${inputUserLogin}      ${login}
    Input Text     ${inputUserPassword}   ${password}
    Click Element  ${buttonSubmit}