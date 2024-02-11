*** Variables ***
${classCustomerGroupForm}  CustomerGroupForm-module-view
${NameNewGroupCustomer}    xpath=//div[contains(@class, '${classCustomerGroupForm}')]//input
${OpenListManager}         xpath=//div[contains(@class, '${classCustomerGroupForm}')]//button[@type='button' and ((@aria-label='Open')or(@aria-label='Close'))]
${ManagerGroupCustomer}    xpath=//li[@id='combo-box-1-option-0']
${AddCustomer}             xpath=//div[contains(@class, '${classCustomerGroupForm}')]/div[2]//button[2]  #//button[@title='Pick']
${buttonSave}              xpath=//button[@type='button']//span[normalize-space(.) = 'Save']

*** Keyword ***
Create New Group In Window Customer
    Wait Download Page
    Wait Is Visible Element And Input Text   ${NameNewGroupCustomer}   ${new.name.group}
    Wait Is Visible Element And Click   ${OpenListManager}
    Wait Is Visible Element And Click   ${ManagerGroupCustomer}

    FOR   ${index}   IN    1    2    3
          Wait Is Visible Element And Click  xpath=//div[contains(@class, 'MuiList-root MuiList-dense MuiList-padding')]/div[${index}]
    END
    Wait Is Visible Element And Click   ${AddCustomer}

    Wait Is Visible Element And Click   ${buttonSave}
    Wait Download Page