-- Вставка данных в таблицу "User"
INSERT INTO "User" (email, login, name, birthday)
VALUES
    ('user1@example.com', 'user_____1', 'User One', '1990-01-15'),
    ('user2@example.com', 'user_____2', 'User Two', '1985-05-20'),
    ('user3@example.com', 'user_____3', 'User Three', '2000-11-10'),
    ('user4@example.com', 'user_____4', 'User Four', '1998-07-03'),
    ('user5@example.com', 'user_____5', 'User Five', '1992-09-25'),
    ('user6@example.com', 'user_____6', 'User Six', '1987-04-12'),
    ('user7@example.com', 'user_____7', 'User Seven', '1996-03-30'),
    ('user8@example.com', 'user_____8', 'User Eight', '1983-08-07'),
    ('user9@example.com', 'user_____9', 'User Nine', '1994-12-18'),
    ('user10@example.com', 'user_____10', 'User Ten', '2002-02-28');
-- Вставка данных в таблицу "Film"
INSERT INTO Film (name, description, releaseDate, duration, user_id)
VALUES
    ('Film 1', 'Description for Film 1', '2023-01-10', 120, 1),
    ('Film 2', 'Description for Film 2', '2022-05-15', 135, 2),
    ('Film 3', 'Description for Film 3', '2023-03-20', 110, 3),
    ('Film 4', 'Description for Film 4', '2021-09-05', 145, 4),
    ('Film 5', 'Description for Film 5', '2022-11-30', 125, 5),
    ('Film 6', 'Description for Film 6', '2022-07-12', 130, 6),
    ('Film 7', 'Description for Film 7', '2023-02-18', 140, 7),
    ('Film 8', 'Description for Film 8', '2022-04-22', 115, 8),
    ('Film 9', 'Description for Film 9', '2022-10-08', 150, 9),
    ('Film 10', 'Description for Film 10', '2021-12-25', 128, 10);
-- Вставка данных в таблицу "Friendship"
INSERT INTO Friendship (user_id1, user_id2)
VALUES
    (1, 2),
    (1, 3),
    (2, 4),
    (3, 5),
    (4, 6),
    (5, 7),
    (6, 8),
    (7, 9),
    (8, 10),
    (9, 10);
