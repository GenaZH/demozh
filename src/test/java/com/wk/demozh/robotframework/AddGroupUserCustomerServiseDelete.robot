*** Settings ***
Documentation      Add Group User, Customer and Servise Then Delete

#Library    GetIdByNameGroup
# scr.test.java.com.wk.demozh.robotframework.config.  # d:/demozh/src/main/java/

Resource           resources/Resources.robot
Resource           config/AllLibrary.robot
Resource           config/BaseTest.robot
Resource           pages/MenuBaseTopDown.robot
Resource           pages/MenuAdminBaseLeft.robot
Resource           pages/WindowAreYouSureDeleteSelected.robot
Resource           pages/WindowNewGroupCustomer.robot
Resource           pages/WindowNewGroupService.robot
Resource           pages/WindowNewGroupUser.robot

Suite Setup        Open Browser To Login Page Admin And Connect To Database  # Запускается перед тест-сьютом
Suite Teardown     Close Browser End Suite                                   # Запускается после тест-сьюта
Test Setup         log To Console   \n                                       # Запускается перед тест-кейсом
Test Teardown      log To Console   \n                                       # Запускается после тест-кейса

*** Variables ***
${LogToConsole}    True

*** Test Cases ***
Add Customer Group And Delete        # Ctrl + /

#    To Console  0000
##    ${id}=  Get Java Api Id Group New Name Group AutoTest   ${new.name.group}   customer
#    ${id}=  Get Java Api Id
#    To Console  ${id} - Get Java Api Id Group
#
#    Should Be Equal As Integers   ${id}   25

    To Console  Delete New Name Group AutoTest
    Click Menu Groups Customer
    Delete New Name Group AutoTest

    To Console  Create New Group
    Click Menu Customer Add Group
    Create New Group In Window Customer

    To Console  Check existence Of Row
    Click Menu Groups Customer
    Check existence Of Row

    Get Data is API And DB Comparison And Delete   customer


Add Service Group And Delete
   To Console   Delete New Name Group AutoTest
   Click Menu Groups Service
   Delete New Name Group AutoTest

   To Console  Create New Group
   Click Menu Services Add Group
   Create New Group In Window Service

   To Console  Check existence Of Row
   Click Menu Groups Service
   Check existence Of Row

   Get Data is API And DB Comparison And Delete   service


Add User Group And Delete   # 8 - henadzi.zherela  10 - andrei.ivanov  9 - test.demozh
   To Console  Delete New Name Group AutoTest
   Click Menu Groups User
   Delete New Name Group AutoTest

   To Console  Create New Group
   Click Menu Users Add Group
   Create New Group In Window User

   To Console  Check existence Of Row
   Click Menu Groups User
   Check existence Of Row

   Get Data is API And DB Comparison And Delete   user