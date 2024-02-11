*** Variables ***
${url.base.api}         https://192.168.85.85:8082
${url.autorization}     https://192.168.85.85:5000/page/login
${browser}              Chrome
${wait}                 60

${admin.login}          Test.Demozh
${admin.password}       Qwerty123
${admin.token}          Qwerty123

${new.name.group}       New Name Group AutoTest

${db.driver}            psycopg2  # для postgres  https://robocorp.com/docs/development-guide/databases
${db.url}               192.168.85.85
${db.port}              5432
${db.name}              demozh
${db.username}          demozh
${db.password}          demozh

