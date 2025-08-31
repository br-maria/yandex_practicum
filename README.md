Project_template
Это шаблон для решения проектной работы. Структура этого файла повторяет структуру заданий. Заполняйте его по мере работы над решением.

Задание 1. Анализ и планирование
Чтобы составить документ с описанием текущей архитектуры приложения, можно часть информации взять из описания компании и условия задания. Это нормально.

1. Описание функциональности монолитного приложения
Управление устройствами:

Пользователи могут управлять отоплением: увеличивать или уменьшать температуру
Система поддерживает управление от сервера к датчику
Система поддерживает синхронное взаимодействие
Система не поддерживает асинхронные вызовы, реактивное взаимодействие
телеметрия:

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

Управление устройствами 
Контекст: централизованное управление системами отопления
Границы:
телеметрия
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

[Диаграмма контекста в модели C4]([URL](https://editor.plantuml.com/uml/bLExJkD05Etp5KCQWWHnGqM5XEXO2IsYHiOP4Kks4td6MkX24EoY891ew1Oj_428Oc78wnVk_D6UEuwJ2491utdSEOyvSxsjj1lh90nAAtxa1KbDYhhMJRNbEB7xgthYwtfod2WPUur8oqXNlKReD0CtOio6qhN0FtPsDZVsUUlmnvuJkahB65j7EumurTKcivTM1TtJY5Bp1z-CKc7EpOMvncACMPkoqhwCLIEgU8dIZL36ww9CZpIcWRcXLumzwk9OokiorvvfObhKnVx0t86tBIWJz8wJ8zD61KZAJCjSs9g53cc2HOk9e8sIe9wWFeuEAIsl5GvKKtg-6_XAiyu_2xg2vwvbX5chVsywgB3AgD3dPHyM1kRM_8PUVb5ilk2IxAIVtuCBvWvc4KBEQCsnXOCpn1TMb1rOvWcb2HWxz3QrMivTpN5TBY040OLP9haygtnCXGykIwCpap_QFTMLkdIr7vqSp9nya1nZEcPhXT8Nhx9C2y0tg75JF4w9tjbdtsOpCXrpMVefWuLUc0VoBGKcMNpEEStVQV-bzauBJRJq4GkgAVnJDWymnBRGom88n9EXQOSMNlJ1bw5lowY6V-G_))

Задание 2. Проектирование микросервисной архитектуры
В этом задании вам нужно предоставить только диаграммы в модели C4. Мы не просим вас отдельно описывать получившиеся микросервисы и то, как вы определили взаимодействия между компонентами To-Be системы. Если вы правильно подготовите диаграммы C4, они и так это покажут.

[Диаграмма контейнеров (Containers)](https://github.com/br-maria/yandex_practicum/blob/main/%D0%B4%D0%B8%D0%B0%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B0.png)


[Диаграмма компонентов (Components)](https://editor.plantuml.com/uml/fLTDRzj64BqBq7zWTQa3r1PGvDHJ705DKwIjQZleCQ2aZQsM8WLo6SCe0iYAawPm0wT1Ja4GDmqAz5OvCHjQjkI_iFkF-cQNf2c6Axc80KicT-RDnzjzixuMSDldOS-fLZxfiBjTbrcDgmslr_TSvd9hY_D-y4MzxjlRAvjTlXMsme3vRS_bM5rfUxrwtx5TybyEUCVfjkgDgyjDUdNxcrlrdXrmvkFLdGnnfQzZTTss4tPOw3lvUDLAjVAf9Pw9YOZaOtp68hBahdmWVyN357yDHLojD9aVUEvIEmoursF-PrPD78gfE9M_YVVuVYj6i8lekKPhpqMiF4TY8Xy1SWeie5doWJYN0xn-2zC3H1pY5LdYvLISA1zWYJCHrwuagRt0ofauLnWHy8Potu9H98wM5LWiJh7sBwqXwa6rihw37lJkNFT2jsFxEqk1UbOf5yr5LBjY_LojMFXfeCKssF2NjbbhjTydXsU6CF33yXgps_m2G8CaVIMGspVdz4dkYZ60JYnyJEYb7CWzBA496RO5avBYZwbvCxrCYwUcbQQo6l8jIkOfsZtKIB3VG-mnKdgaV6dzJH5JxGOajujF6ANCb0VfTu6nshn9UP-IByMfwKQ-1seCzodIZpAgDRuECI1MrKOuIqFSrrz5WdfUg-kmXAENS3WYUj1Zx340clZwqWavJeU9COtwCQGb0IpvH8nL6oT4LsofGeyf6IAml7z9JH_3qn39ZjNZoCnJsZiJLLzjR3GjnHP5807ONy26dMAH-xTUXwty69Xw3DiRDcVRzauIFddIcqG-LDi3-TF-HZdo5wgxl110hNaXrsBq4Yu3-HY_rBUOyizrwvKuKjqw0kAG46SA98gD8QXCttCS7OQqQ9AerIcr7W7tLOZVLL0IqTrbjVFUQSwCmElClzTjC_9zdMp-M3Nx4iS5xqQag78_pxE1dexDxPOTC9tbY91p0F8X1Mnw0T_qsVhtjqp4THXbks6t70NqvaFHLed_fRUzEdqnHaXKek_bBS64kzlTp0BeJjF6VmU4WQOJjPO7KLic3HE9SNa86gHPWD8JRWvmNceEPXPqlwttJpdRvHeEenlUV1uQt7UCCc0Qg8QJe4SCbNiyZvbv8HN61smbquAS_iX2ZjJ-pTDrGccOzOhTm-VrC22Olqbs5GHfFZOl7VKJGs45emKQ1jqrS4IrAYqQNEYABkixKklFZLA7nORdAxn_n37LkX3BMYmTtFk9kRbK_qn5Fv6ECdw-_c73V29oMFFEH952BPvxQl0U56JeVd9rErJsb5yy8pdLoXfpSfV9xAxq2kR52s9-W-fPDEkS7zkNyzS8wOLbPYGPfX_PvmRdPLoqKs62pEh-l9cHE6VM1Vrzhg_cf1yeS6OWb7aNnFL_Ui_evW9VK-QfVBp8as7Ggh8SygVfK3deow8wwHSNdsIKQ_zyvBoClBuG1dMFBXjGAduMitZeBdlzgbQkCRUZ_l_w3m00)

Добавьте диаграмму для каждого из выделенных микросервисов.

[Диаграмма кода (Code) для api-сервиса](https://editor.plantuml.com/uml/bLHBRi8m5DnRyXsyJ5N20LWWK5krQsWFy6GUmS8undOegENkjUCWujHKr8j4UZEUURzaPXqOr-ma9NOhb0O3EwQ1Rw72fJj9P0Qv0rL9f8II3c6WnIiu_8GJ-wA4-SCbMClcMZpLofbQIZGNA9n7jW6rahZ0VOFM5GRt8ozj7_gK0qYnyh8zKeUVuoi-XN9eri2HTSItLZhh5pG2PS90dQvYvq4nYxfnLu5OInkplforg59ftiOQWv5IWDOJzdBKlXwRIpZgFUD1SEoSyEXGhUmT5NJNydtBs7nODFysQI_Tj1XsQuacv9IsA-OvWA97XIwYXLXDc7L6g2ePVAF3s7znHio7OJ2wNBstN0Fsj-U0SPVZl76Rh2Du09KJt0iNhjwYoZfpWvxm7l2YyVwvtKm_fBBydWwcI4cod-FnD5cm37nT34gINIpBQJezIdfB5D1UZzlKBjK7sLutA9dvVMj_9Zy0)

[Диаграмма кода для сервиса управления](https://editor.plantuml.com/uml/fPBFQiCm3CRlWRo3ZnbRNo27KRgDdGg5i0TG73KrTUGWou4o-kxBlz8uwqxpmGPzFycVP6-z04jeR9huiw4M61hLWZv3ZOLSB2f6BK2rnJH9arbHsf6mimLoPpIgxpHH_T8Ml5VlECJsG3t8DsbOp-eJPL8B0Ga-CrMklB2X-cc9VRKL24xacwEZgHVaot1v7yhL4fZphzEnj3FfVzdvLJuoKa3tVmCV7P8Ss6dqtgqSpE4HoN3ORrN7qBteTJdz4Tm57yzztnVgrHsxyxhHGoYjyQTCN6lqlOzcoiWLq2NkEvHUiobndN42gYnohew1zCfT_EwRpMliA4tYbtW0h2RrWDWYLUDd_G40)

[Диаграмма кода для сервиса авторизации](https://editor.plantuml.com/uml/XL71IWCn4Bq7yWyvhaWl7dkGLb2f5yLMFG_9k0sRJPQPR258_zsaMs4R5EVmSdYFUVDULXo1ujWxARYpVW22NWsWEsXn6vD3HQWZ-DQX55AS6GLZt6-H3bQZ-f92vT4EcDNpEZCtBnGErY3zS6MkrOPvnBNMoBmB7VfcPAIbUijuDTUzWxC68awYM72fE9BrxLbtd9wvSTdoYaDW6mEbI-C7wqtXxzB6DDPKoshDVG_MDLZmVzlJZLKJqy97z4WvnTF7hXaWkG3P67owZ8faFrEH_17pM5glIbqiRgkulqhcfqcnGczEt_mD)

Добавьте одну диаграмму или несколько.

Задание 3. Разработка ER-диаграммы
Добавьте сюда ER-диаграмму. Она должна отражать ключевые сущности системы, их атрибуты и тип связей между ними.
[ER-диаграмма](https://editor.plantuml.com/uml/hPH1RzCm68RlaV8Vh9usf4bbKZdqD8c1XE2013rDg3B9HsgQsC5sEgeDgUiGbqtQZSCka-0Fb8s9ZjBz1liVyTdDjcQK2g7baiJVw-Xvtxp9Xj9KwY9Bmq1r6S-ff1b96GVTpu48gJjYVfBJg4iJUA7xAH09aQOyII4CmW2uPhfFQkR4N9g9FJG_y7ngHdPepjrzZL15MWeasGa3WiSz5fCcQRMUR9AjvqzVpHOXeop5vHwLKOVAbVL6OvLi5PozAw2Kv5IfRI7ZTeUgJaNwO7McY2HG3N6RQXp7UAbP1hDHaSUBHXyg3hxQFJkq0-I_S5VeujBJRqAFHR2KdzCCvfZkr-ibau_pPj2uMiVuTQ7cRTJloCKnya_jHpCsPtOVtOpi9pEsHzx9Gy7ViAIGL3F1bngAlUVstEZnrKY1remd3lwj4lprRBK7Khc7DWdZ6XAGIzrKaRyWya-iozH3lXHTM0vNO9qMecc_jLgZic3lSoP1BKhrdn0_-oodPcGcnEuXxpTxW1KPcmlF_AY7ocSY-TzCmUrl_wqi24MhQJj4h52M_udilxNTtRKriLD6sKJ-iVc50P_ROQsgABlj9ATcWlQ-NylAKIciLkVs8wlQwpISxCozM9GDi8K3krzk28CDu37-Vtu3)

Задание 4. Создание и документирование API
1. Тип API
Укажите, какой тип API вы будете использовать для взаимодействия микросервисов. Объясните своё решение.
REST API 
Плюсы:
Гибкость и масштабируемость
Кэширование данных на уровне HTTP
Один из самых популярных форматов, много, где используется - не будет сложностей с разработкой и интеграциями
AsyncAPI
Параллельная обработка запросов
Поддержка различных протоколов: MQTT

3. Документация API
Здесь приложите ссылки на документацию API для микросервисов, которые вы спроектировали в первой части проектной работы. Для документирования используйте Swagger/OpenAPI или AsyncAPI.
[Документация API](https://editor.swagger.io/?_gl=1*9414n*_gcl_au*MjEzNzYyNDgwMy4xNzU0NDEzODgy) - у меня открывается корректно, на всякий случай прикладываю код yaml

swagger: '2.0'
info:
  version: '1.0.0'
  title: Умный дом API
  description: API для управления устройствами и температурой в умном доме
host: smart-home.api.com
basePath: /api/v1
schemes:
  - http
  - https
paths:
  /devices:
    get:
      summary: Получение списка всех устройств
      description: Возвращает список всех устройств в системе
      responses:
        '200':
          description: Успешный ответ
          schema:
            type: array
            items:
              $ref: '#/definitions/Device'
    post:
      summary: Добавление нового устройства
      description: Добавляет новое устройство в систему
      parameters:
        - in: body
          name: device
          description: Данные нового устройства
          required: true
          schema:
            $ref: '#/definitions/Device'
      responses:
        '201':
          description: Устройство успешно добавлено
  /devices/{deviceId}:
    get:
      summary: Получение информации об устройстве
      parameters:
        - name: deviceId
          in: path
          required: true
          type: string
      responses:
        '200':
          description: Успешный ответ
          schema:
            $ref: '#/definitions/Device'
    put:
      summary: Обновление информации об устройстве
      parameters:
        - name: deviceId
          in: path
          required: true
          type: string
        - in: body
          name: device
          description: Обновленные данные устройства
          required: true
          schema:
            $ref: '#/definitions/Device'
      responses:
        '200':
          description: Устройство успешно обновлено
  /temperature:
    get:
      summary: Получение текущей температуры
      responses:
        '200':
          description: Успешный ответ
          schema:
            $ref: '#/definitions/Temperature'
    put:
      summary: Установка новой температуры
      parameters:
        - in: body
          name: temperature
          description: Новая температура
          required: true
          schema:
            $ref: '#/definitions/Temperature'
      responses:
        '200':
          description: Температура успешно установлена
definitions:
  Device:
    type: object
    properties:
      id:
        type: string
        description: Уникальный идентификатор устройства
      name:
        type: string
        description: Название устройства
      type:
        type: string
        description: Тип устройства (термостат, свет, розетка и т.д.)
      status:
        type: boolean
        description: Статус устройства (включено/выключено)

  Temperature:
    type: object
    properties:
      current:
        type: number
        format: float
        description: Текущая температура
      target:
        type: number
        format: float
        description: Целевая температура
      min:
        type: number
        format: float
        description: Минимальная допустимая температура
      max:
        type: number
        format: float
        description: Максимальная допустимая температура


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
