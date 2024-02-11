*** Variables ***
${classUserGroupForm}  UserForm-module-userForm
${NameNewGroupUser}    xpath=//div[@id='Group-tabpanel']/div/div/div/div/div[2]//input

${AddUser}             xpath=//div[contains(@class, '${classUserGroupForm}')]//button[@title='Pick']
${buttonSave}          xpath=//button[@type='button']//span[normalize-space(.) = 'Save']

*** Keyword ***
Create New Group In Window User
    Wait Download Page
    Wait Is Visible Element And Input Text  ${NameNewGroupUser}   ${new.name.group}

    FOR    ${index}    IN    1    2
           Wait Is Visible Element And Click  xpath=//div[contains(@class, 'MuiList-root MuiList-dense MuiList-padding')]/div[${index}]
    END
    Wait Is Visible Element And Click  ${AddUser}

    Wait Is Visible Element And Click  ${buttonSave}
    Wait Download Page