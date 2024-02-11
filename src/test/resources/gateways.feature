# language: ru

Функционал: Добавление Gateways и проверка что добавилось

  Предыстория: Открытие браузера и авторизация администратором
    Когда Oткрываем браузер "https://192.168.85.85:5000/page/login"
    И  Oткрываем браузер "https://192.168.85.85:5000/page/login"
    И  Вводим логин и пароль администратора "Test.Demozh" и "Qwerty123"
    И  Вводим токен администратора "Qwerty123"
    Тогда Нажимаем кнопку переключения с режима "User"

    Сценарий: Добавление Gateways и проверяем, что добавилось и удаляем
      Когда Нажимаем пункт меню Gateways
      И  Проверяем наличие "Test Gateways" и удаляем
      И  Нажимаем пункт меню Add Gateways
      И  Вводим Name Gateways "Test Gateways"
      И  Вводим DNS Name Gateways "Test DNS Gateways"
      И  Вводим Port Gateways "5555"
      И  Выбираем Type Gateways
      И  Нажимаем кнопку Save
     # И  Проверяем наличие "Test Gateways" и удаляем
