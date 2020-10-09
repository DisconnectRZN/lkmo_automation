# new feature
# Tags: optional

# Логины и пароли которые используются при проверке разных автотестов (РМС + ЛКМО)
#lkmotestdataadmin1 // Nouser1
#lkmotestmanager1 // Nouser1
#lkmotestassistant1 // Nouser1
#lkmotestcurator1 // Nouser1
#lkmo.test1 // Nouser1

Feature: Проверка главной страницы в ЛКМО

  @MainPage
  Scenario: Проверка главной страницы в ЛКМО с правами Администратора Данных ЛКМО
    Given Открыть главную страницу сайта
    When Проверка ввода Логина и Пароля и входа в ЛКМО
    When Проверить отображение логотипа Invitro
    When Проверить отображение UserName авторизованного пользователя
    When Проверить отображение фильтра поиска МО
    When Проверить доступность и отображение таблицы МО
    When Проверка поиска МО по его названию
    When Проверить доступности кнопки Сброса фильтра поиска ее нажатие
    When Проверка поиска МО по его агломерации
    When Проверка поиска МО по его статусу
    When Проверка поиска МО по полю Менеджер/Ассистент
    When Проверка поиска МО по полям Страна, Регион, Город
    When Проверить доступности кнопки выхода из ЛКМО и ее нажатие

