Project_template
Это шаблон для решения проектной работы. Структура этого файла повторяет структуру заданий. Заполняйте его по мере работы над решением.

Задание 1. Анализ и планирование
Чтобы составить документ с описанием текущей архитектуры приложения, можно часть информации взять из описания компании и условия задания. Это нормально.

1. Описание функциональности монолитного приложения
Управление отоплением:

Пользователи могут управлять отоплением: увеличивать или уменьшать температуру
Система поддерживает управление от сервера к датчику
Система поддерживает синхронное взаимодействие
Система не поддерживает асинхронные вызовы, реактивное взаимодействие
Мониторинг температуры:

Пользователи могут получать данные о температуре
Система поддерживает получение запроса от сервера к датчику
Отсутствует возможность самостоятельного подключения нового датчика пользователем

2. Анализ архитектуры монолитного приложения
Язык программирования: Go
База данных: PostgreSQL
Архитектура: Монолитная, все компоненты системы (обработка запросов, бизнес-логика, работа с данными) находятся в рамках одного приложения.
Взаимодействие: Синхронное, запросы обрабатываются последовательно.
Масштабируемость: Ограничена, так как монолит сложно масштабировать по частям.
Развертывание: Требует остановки всего приложения.

3. Определение доменов и границы контекстов
Опишите здесь домены, которые вы выделили.
Сервисное обслуживание 
Контекст: поддержка и обслуживание систем
Границы:
Планирование технического обслуживания
Управление заявками
Контроль работы сервисных бригад

Управление отоплением 
Контекст: централизованное управление системами отопления
Границы:
Мониторинг температуры в реальном времени
Настройка температуры


4. Проблемы монолитного решения
добавление новых возможностей требует переработки всего монолита
любое обновление затрагивает всю систему, при обновлениях система становится недоступной, сбой может вывести из строя всю систему
необходимость тестирования всего приложения после каждого изменения
сложно оптимизировать работу с базой данных
трудно интегрировать сторонние системы
разработчики ограничены в параллельной работе
нет возможности обрабатывать большие потоки данных из-за отсутствия асинхронности

5. Визуализация контекста системы — диаграмма С4
Добавьте сюда диаграмму контекста в модели C4.

@startuml
!include https://raw.githubusercontent.com/plantuml-stdlib/C4-PlantUML/master/C4_Context.puml

' Внешние сущности
Person(customer, "Пользователь", "Управляет и контролирует температуру в доме")
Person(specialist, "Специалист", "Выполняет подключение оборудования к системе")
System(system, "Теплый дом", "Система для управления и контроля температуры")
System_Ext(heatingSystem, "Система отопления", "Управляет температурой")

' Потоки данных
Rel(customer, system, "Управляет температурой")
Rel(specialist, system, "Осуществляет подключение")
Rel(system, heatingSystem, "Запрос на изменение температуры")
@enduml

Задание 2. Проектирование микросервисной архитектуры
В этом задании вам нужно предоставить только диаграммы в модели C4. Мы не просим вас отдельно описывать получившиеся микросервисы и то, как вы определили взаимодействия между компонентами To-Be системы. Если вы правильно подготовите диаграммы C4, они и так это покажут.

Диаграмма контейнеров (Containers)

@startuml
!define C4Container https://raw.githubusercontent.com/plantuml-stdlib/C4-PlantUML/master/C4_Container.puml
!includeurl C4Container

' Внешние сущности
Person(customer, "Пользователь", "Дистанционно управляет устройствами")

' Контейнеры системы
System_Boundary(system, "Приложение") {
    Container(webApp, "Веб-приложение", "React", "Интерфейс управления")
    Container(api, "API", "Node.js", "Обрабатывает запросы")
    Container(mobileApp, "Мобильное приложение", "Flutter", "Мобильный интерфейс управления")
    ContainerDb(database, "База данных", "PostgreSQL", "Хранит информацию о подключенных устройствах, их конфигурациях")
    Container(controlService, "Сервис управления", "Go", "Обрабатывает запросы на получение/изменение текущих конфигураций")
    Container(authService, "Сервис авторизации", "OAuth2", "Обрабатывает авторизацию и регистрацию пользователей")
}

' Потоки данных
Rel(customer, webApp, "Использует для дистанционного управления устройствами")
Rel(webApp, api, "Обрабатывает запросы")
Rel(mobileApp, api, "Обрабатывает запросы")
Rel(api, database, "Запросы к базе данных")
Rel(api, controlService, "Запросы на изменение")
Rel(api, authService, "Запросы на авторизацию")
@enduml

Диаграмма компонентов (Components)
[Тык](https://editor.plantuml.com/uml/fLTDRzj64BqBq7zWTQa3r1PGvDHJ705DKwIjQZleCQ2aZQsM8WLo6SCe0iYAawPm0wT1Ja4GDmqAz5OvCHjQjkI_iFkF-cQNf2c6Axc80KicT-RDnzjzixuMSDldOS-fLZxfiBjTbrcDgmslr_TSvd9hY_D-y4MzxjlRAvjTlXMsme3vRS_bM5rfUxrwtx5TybyEUCVfjkgDgyjDUdNxcrlrdXrmvkFLdGnnfQzZTTss4tPOw3lvUDLAjVAf9Pw9YOZaOtp68hBahdmWVyN357yDHLojD9aVUEvIEmoursF-PrPD78gfE9M_YVVuVYj6i8lekKPhpqMiF4TY8Xy1SWeie5doWJYN0xn-2zC3H1pY5LdYvLISA1zWYJCHrwuagRt0ofauLnWHy8Potu9H98wM5LWiJh7sBwqXwa6rihw37lJkNFT2jsFxEqk1UbOf5yr5LBjY_LojMFXfeCKssF2NjbbhjTydXsU6CF33yXgps_m2G8CaVIMGspVdz4dkYZ60JYnyJEYb7CWzBA496RO5avBYZwbvCxrCYwUcbQQo6l8jIkOfsZtKIB3VG-mnKdgaV6dzJH5JxGOajujF6ANCb0VfTu6nshn9UP-IByMfwKQ-1seCzodIZpAgDRuECI1MrKOuIqFSrrz5WdfUg-kmXAENS3WYUj1Zx340clZwqWavJeU9COtwCQGb0IpvH8nL6oT4LsofGeyf6IAml7z9JH_3qn39ZjNZoCnJsZiJLLzjR3GjnHP5807ONy26dMAH-xTUXwty69Xw3DiRDcVRzauIFddIcqG-LDi3-TF-HZdo5wgxl110hNaXrsBq4Yu3-HY_rBUOyizrwvKuKjqw0kAG46SA98gD8QXCttCS7OQqQ9AerIcr7W7tLOZVLL0IqTrbjVFUQSwCmElClzTjC_9zdMp-M3Nx4iS5xqQag78_pxE1dexDxPOTC9tbY91p0F8X1Mnw0T_qsVhtjqp4THXbks6t70NqvaFHLed_fRUzEdqnHaXKek_bBS64kzlTp0BeJjF6VmU4WQOJjPO7KLic3HE9SNa86gHPWD8JRWvmNceEPXPqlwttJpdRvHeEenlUV1uQt7UCCc0Qg8QJe4SCbNiyZvbv8HN61smbquAS_iX2ZjJ-pTDrGccOzOhTm-VrC22Olqbs5GHfFZOl7VKJGs45emKQ1jqrS4IrAYqQNEYABkixKklFZLA7nORdAxn_n37LkX3BMYmTtFk9kRbK_qn5Fv6ECdw-_c73V29oMFFEH952BPvxQl0U56JeVd9rErJsb5yy8pdLoXfpSfV9xAxq2kR52s9-W-fPDEkS7zkNyzS8wOLbPYGPfX_PvmRdPLoqKs62pEh-l9cHE6VM1Vrzhg_cf1yeS6OWb7aNnFL_Ui_evW9VK-QfVBp8as7Ggh8SygVfK3deow8wwHSNdsIKQ_zyvBoClBuG1dMFBXjGAduMitZeBdlzgbQkCRUZ_l_w3m00)

Добавьте диаграмму для каждого из выделенных микросервисов.

Диаграмма кода (Code)

Добавьте одну диаграмму или несколько.

Задание 3. Разработка ER-диаграммы
Добавьте сюда ER-диаграмму. Она должна отражать ключевые сущности системы, их атрибуты и тип связей между ними.

Задание 4. Создание и документирование API
1. Тип API
Укажите, какой тип API вы будете использовать для взаимодействия микросервисов. Объясните своё решение.
REST API
Плюсы:
Гибкость и масштабируемость
Кэширование данных на уровне HTTP
Один из самых популярных форматов, много, где используется - не будет сложностей с разработкой и интеграциями
2. Документация API
Здесь приложите ссылки на документацию API для микросервисов, которые вы спроектировали в первой части проектной работы. Для документирования используйте Swagger/OpenAPI или AsyncAPI.
https://editor.swagger.io/?_gl=1*9414n*_gcl_au*MjEzNzYyNDgwMy4xNzU0NDEzODgy
Задание 5. Работа с docker и docker-compose
Перейдите в apps.

Там находится приложение-монолит для работы с датчиками температуры. В README.md описано как запустить решение.

Вам нужно:

сделать простое приложение temperature-api на любом удобном для вас языке программирования, которое при запросе /temperature?location= будет отдавать рандомное значение температуры.
Locations - название комнаты, sensorId - идентификатор названия комнаты

	// If no location is provided, use a default based on sensor ID
	if location == "" {
		switch sensorID {
		case "1":
			location = "Living Room"
		case "2":
			location = "Bedroom"
		case "3":
			location = "Kitchen"
		default:
			location = "Unknown"
		}
	}

	// If no sensor ID is provided, generate one based on location
	if sensorID == "" {
		switch location {
		case "Living Room":
			sensorID = "1"
		case "Bedroom":
			sensorID = "2"
		case "Kitchen":
			sensorID = "3"
		default:
			sensorID = "0"
		}
	}
Приложение следует упаковать в Docker и добавить в docker-compose. Порт по умолчанию должен быть 8081

Кроме того для smart_home приложения требуется база данных - добавьте в docker-compose файл настройки для запуска postgres с указанием скрипта инициализации ./smart_home/init.sql

Для проверки можно использовать Postman коллекцию smarthome-api.postman_collection.json и вызвать:

Create Sensor
Get All Sensors
Должно при каждом вызове отображаться разное значение температуры

Ревьюер будет проверять точно так же.
