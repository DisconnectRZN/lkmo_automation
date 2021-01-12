# new feature
# Tags: optional

# Логины и пароли которые используются при проверке разных автотестов (РМС + ЛКМО)
#lkmotestdataadmin1 // Nouser1
#lkmotestmanager1 // Nouser1
#lkmotestassistant1 // Nouser1
#lkmotestcurator1 // Nouser1
#lkmo.test1 // Nouser1

Feature: Детальная проверка работ с расписанием МО

  @NewRaspisanieMO
  Scenario: Проверка создания расписания МО
    Given Открыть главную страницу сайта
    When Проверка ввода Логина и Пароля и входа в ЛКМО
    When Проверка поиска МО по его названию
    When Проверка перехода к детальной информации найденного МО