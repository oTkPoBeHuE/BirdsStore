# BirdsStore
Видео: https://youtu.be/FKhwmUMmnt0

Инструкция:
Просто запустить jar

Путь либо полный либо относительный до фалов. Например:
D:\dir\user.txt
Или:
1.txt

Интерфейс я ограничил следующей функциональностью:
-Добавление пользователя
-Модификация счета пользователя
-Добавление продукта
-Покупка
-Запись пользователей в файл
-Запись списка сделок в файл.
-Чтение пользователей из файла


Корректность вводимых логина и пароля: 
USERNAME_MAX_LENGTH = 10;
USERNAME_MIN_LENGTH = 2;

PASSWORD_MAX_LENGTH = 10;
PASSWORD_MIN_LENGTH = 3;

Так же они проверяются по маске a-zA-Z0-9_-

