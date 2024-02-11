*** Variables ***
${confirmationButtonDelete}       xpath=//div[@role='dialog']//span[normalize-space(.) = 'Delete']

*** Keyword ***
Window Confirmation Delete
    Sleep   1
    Wait Is Visible Element And Click  ${confirmationButtonDelete}
    Wait Download Page

