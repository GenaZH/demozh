*** Variables ***
${inputUserToken}           id=psw
${buttonSubmitToken}        name=submitt

*** Keyword ***
Input Token
    [Arguments]      ${token}
    Wait Until Element Is Visible  ${buttonSubmitToken}  ${wait}
    Input Text  ${inputUserToken}  ${admin.token}
    Click Element  ${buttonSubmitToken}
