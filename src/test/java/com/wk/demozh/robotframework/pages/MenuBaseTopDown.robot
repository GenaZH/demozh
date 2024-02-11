*** Variables ***
${buttonModeUserOrAdmin}  xpath=//div[@id='root']//div[@class='MainView-module-switchCheckboxNo__2xkpms4']
${inputSearch}            xpath=//div[@id='header-portal']//input[contains(@placeholder, 'Search') and @type='text']

${presenceTable}          xpath=//table[contains(@class, 'MuiTable-root')]
${presenceRowsInTable}    xpath=//tr[contains(@class, 'MuiTableRow-root')]//td[contains(@class, 'MuiTableCell-root')]
${deleteFirstRow}         xpath=//tbody[contains(@class, 'MuiTableBody-root')]/tr//span[normalize-space(.) = 'delete']

*** Keyword ***
To know Mode
    [Arguments]                        ${mode}
    Wait Until Element Is Visible      ${buttonModeUserOrAdmin}   ${wait}
    ${choiceMode}=         Get Text    ${buttonModeUserOrAdmin}
    IF  '${choiceMode}' == '${mode}'
         Click Element                 ${buttonModeUserOrAdmin}
    END

Choice Mode ADMIN
    To know Mode   ADMIN

Choice Mode USER
    To know Mode   USER

Input Text In Search
    [Arguments]                             ${searhText}
    Input Empty Text                        ${inputSearch}
    Wait Is Visible Element And Input Text  ${inputSearch}   ${searhText}
    Wait Download Page

Check existence Of Row
   Input Text In Search      ${new.name.group}
   ${Equal}=   Absence Quantity Rows Per Page
   Should Be Equal           ${Equal}   ${1}

Absence Quantity Rows Per Page
    TRY
        Wait Until Element Is Visible  ${presenceTable}         ${wait}
        Wait Download Page
        Wait Until Element Is Visible  ${presenceRowsInTable}   1
    EXCEPT
        To Console   EXCEPT - Not Table
        RETURN   ${-1}
    ELSE
        RETURN   ${1}
    END

Delete New Name Group AutoTest
    TRY
        Input Text In Search                     ${new.name.group}
        ${absence}=     Absence Quantity Rows Per Page
        IF  ${absence} == ${-1}
            RETURN
        END
        ${status}=      Click If Visible Element   ${deleteFirstRow}
        IF  '${status}' == 'True'
             Window Confirmation Delete
        END
    EXCEPT
        To Console   EXCEPT - Not Delete New Name Group AutoTest
    END

