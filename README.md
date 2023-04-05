# beatdevTest
rest api документация

Этот проект я решил сделать с паттерном проектирования фасады. Делигировав им работу с дто->ентити. По тз тестового задания, немного не понял что имелось ввиду под "уникальный id нового пользователя", это можно понять как автоинкремент, так и UUID. Сделал без UUID, но если подразумевалось что нужно его использовать, то могу исправить. 

Создал один UserContoller по тз. По rest назначил адрес "/api/v1/users".

Функционалы:
Добавление нового пользователя, метод post, path - "/". Принимает dto объект, объект проходит валидацию аннотацией @valid (ограничения написаны на абстрактном классе UserDTO). Объект имеет поля: name,surname,email,url,status. Каждое поле имеет ограничение и валидацию. В зависимости от назначения дто, добавляются новые поля, но те поля основные. Внутри метода я сделал имитацию обращения и задержку по времени 5-10сек. Эту дто я конвертирую в entity в userFacade, для того, чтобы сохранить эту entity в бд. После сохранения через репозиторий (spring data) я возвращаю entity, из которого я создаю ResponseDTO (по заданию требовалось вернуть только id user, но я решил что чтобы этот процесс был более гибким (например нужно будет вернуть не только id в будущем)) решил вовзращать вместо просто id user'a, обернутую в response entity эту dto. Не встречал эту практику раньше, но решил что это более лучше.

Получение информации о пользователе, метод get, path - "/{id}". Принимаю id юзера через аннотацию PathVariable. Так же имитирую обращения и задержку 5-10сек. Потом из репозитория ищу юзера по id, если нету, то сразу выкидываю кастом эксепшн. Если есть, то в фасад конверстирую ентити в дто и возвращаю в метод контроллера. Который в свою очередь оборачивает объект в responseentity и возвращает json объект. В моем случае в postman. 

Изменение статуса пользователя (онлайн\оффлайн), метод put, path - "/{id}/status". Принимаю id юзера через аннотацию PathVariable. Так же имитирую обращения и задержку 5-10сек. В фасадах я пытаюсь найти пользователя, через userService, если юзер ненайден - эксепшен. При нахождении юзера, меняю его Boolean статус, и обновляю его в бд. Возвращаю DTO, который имеет 3 поля: id пользователя, прошлый статус, нынешний статус.


api я проверил через постман, коллекцию постмана будет в репозитории. Использовал технологии которые были заданы. Обработка ошибок работает, данные в формате json. Некоторые комментарии в коде оставлены для понимания. Написал юнит тесты для методов сервиса (junit+mockito). Мог бы расширить функционал системы, но решил ограничится задачами из тз. Спасибо!
