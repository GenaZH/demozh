*** Variables ***
${NameNewGroupService}    xpath=//div[contains(@class, 'ServiceGroupForm-module-view')]//input

${AddService}             xpath=//div[contains(@class, 'ServiceGroupForm-module-view')]/div[2]//button[2]  #//button[@title='Pick']
${buttonSave}             xpath=//button[@type='button']//span[normalize-space(.) = 'Save']

*** Keyword ***
Create New Group In Window Service
    Wait Download Page
    Wait Is Visible Element And Input Text  ${NameNewGroupService}  ${new.name.group}
    FOR    ${index}    IN    1    2    3
           Wait Is Visible Element And Click  xpath=//div[contains(@class, 'MuiList-root MuiList-dense MuiList-padding')]/div[${index}]
    END
    Wait Is Visible Element And Click       ${AddService}

    Wait Is Visible Element And Click       ${buttonSave}
    Wait Download Page