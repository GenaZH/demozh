*** Variables ***
${adminMenuCustomers}          xpath=//div[@id='Customers-menu']//preceding-sibling::div[1]
${adminMenuAddGroupCustomers}  xpath=//div[@id='Customers-menu']//span[normalize-space(.) = 'Add group']

${adminMenuServices}           xpath=//div[@id='Services-menu']//preceding-sibling::div[1]
${adminMenuAddGroupServices}   xpath=//div[@id='Services-menu']//span[normalize-space(.) = 'Add group']

${adminMenuUsers}              xpath=//div[@id='Users-menu']//preceding-sibling::div[1]
${adminMenuAddGroupUsers}      xpath=//div[@id='Users-menu']//span[normalize-space(.) = 'Add group']

${adminMenuGroups}             xpath=//div[@id='Groups-menu']//preceding-sibling::div[1]
${adminMenuGroupCustomers}     xpath=//div[@id='Groups-menu']//span[normalize-space(.) = 'Customer']
${adminMenuGroupService}       xpath=//div[@id='Groups-menu']//span[normalize-space(.) = 'Service']
${adminMenuGroupUser}          xpath=//div[@id='Groups-menu']//span[normalize-space(.) = 'User']


*** Keyword ***
Click Menu Customer Add Group
    Wait Is Visible Element And Click  ${adminMenuCustomers}
    Wait Is Visible Element And Click  ${adminMenuAddGroupCustomers}

Click Menu Services Add Group
    Wait Is Visible Element And Click  ${adminMenuServices}
    Wait Is Visible Element And Click  ${adminMenuAddGroupServices}

Click Menu Users Add Group
    Wait Is Visible Element And Click  ${adminMenuUsers}
    Wait Is Visible Element And Click  ${adminMenuAddGroupUsers}


Click Menu Groups Customer
    Wait Is Visible Element And Click  ${adminMenuGroups}
    Wait Is Visible Element And Click  ${adminMenuGroupCustomers}

Click Menu Groups Service
    Wait Is Visible Element And Click  ${adminMenuGroups}
    Wait Is Visible Element And Click  ${adminMenuGroupService}

Click Menu Groups User
    Wait Is Visible Element And Click  ${adminMenuGroups}
    Wait Is Visible Element And Click  ${adminMenuGroupUser}