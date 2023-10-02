INSERT INTO "User" (email, login, name, birthday)
VALUES
    ('user1@example.com', 'user1login', 'User One', '1990-01-15'),
    ('user2@example.com', 'user2login', 'User Two', '1985-05-20'),
    ('user3@example.com', 'user3login', 'User Three', '2000-09-10'),
    ('user4@example.com', 'user4login', 'User Four', '1998-03-25'),
    ('user5@example.com', 'user5login', 'User Five', '1993-07-05'),
    ('user6@example.com', 'user6login', 'User Six', '1980-12-12'),
    ('user7@example.com', 'user7login', 'User Seven', '2005-02-28'),
    ('user8@example.com', 'user8login', 'User Eight', '1997-11-08'),
    ('user9@example.com', 'user9login', 'User Nine', '1994-06-15'),
    ('user10@example.com', 'user10login', 'User Ten', '1992-04-30');

INSERT INTO User_Friendship_Status (name)
VALUES
    ('Pending'),
    ('Accepted'),
    ('Blocked'),
    ('Rejected'),
    ('Canceled'),
    ('Active'),
    ('Inactive'),
    ('Requested'),
    ('Connected'),
    ('Disconnected');

INSERT INTO User_Friendship (user_id1, user_id2, status_id)
VALUES
    (1, 2, 2), -- Пользователь 1 и 2 - друзья (статус "Accepted")
    (3, 4, 1), -- Пользователь 3 и 4 - запрос на дружбу (статус "Pending")
    (5, 6, 6), -- Пользователь 5 и 6 - активные друзья (статус "Active")
    (7, 8, 3), -- Пользователь 7 и 8 - заблокированы (статус "Blocked")
    (9, 10, 4); -- Пользователь 9 и 10 - запрос на дружбу отклонен (статус "Rejected")

INSERT INTO Genre (name, description)
VALUES
    ('Action', 'Movies with lots of action scenes'),
    ('Comedy', 'Funny and light-hearted films'),
    ('Drama', 'Serious and emotional storytelling'),
    ('Horror', 'Scary and suspenseful movies'),
    ('Science Fiction', 'Movies set in futuristic or speculative settings'),
    ('Romance', 'Love stories and romantic films'),
    ('Adventure', 'Exciting and adventurous movies'),
    ('Fantasy', 'Movies with magical and fantastical elements'),
    ('Thriller', 'Suspenseful and thrilling films'),
    ('Documentary', 'Non-fiction films about real events');

INSERT INTO MPA (name, description)
VALUES
    ('G', 'General Audiences – All ages are admitted'),
    ('PG', 'Parental Guidance – Some material may not be suitable for children'),
    ('PG-13', 'Parents Strongly Cautioned – Some material may be inappropriate for children under 13'),
    ('R', 'Restricted – Restricted to viewers over the age of 17 or 18'),
    ('NC-17', 'Adults Only – No one 17 and under admitted'),
    ('Unrated', 'Not rated by the MPA'),
    ('NR', 'Not Rated – Not submitted for rating'),
    ('PG-14', 'Parents Strongly Cautioned – Some material may be inappropriate for children under 14'),
    ('R-18', 'Restricted to viewers over the age of 18'),
    ('X', 'Adults Only – Contains explicit sexual content');

INSERT INTO Film (name, description, release_date, duration, genre_id, mpa_id)
VALUES
    ('Film 1', 'Action-packed adventure', '2022-05-10', 120, 1, 2),
    ('Film 2', 'Heartwarming comedy', '2021-08-15', 105, 2, 1),
    ('Film 3', 'Intense drama', '2020-11-20', 150, 3, 4),
    ('Film 4', 'Chilling horror', '2023-03-05', 95, 4, 5),
    ('Film 5', 'Sci-fi epic', '2019-06-30', 180, 5, 3),
    ('Film 6', 'Romantic love story', '2022-02-14', 130, 6, 2),
    ('Film 7', 'Thrilling adventure', '2021-04-25', 140, 7, 1),
    ('Film 8', 'Fantasy world', '2020-10-12', 160, 8, 2),
    ('Film 9', 'Suspenseful thriller', '2023-07-08', 110, 9, 4),
    ('Film 10', 'Inspirational documentary', '2018-09-03', 90, 10, 6);

INSERT INTO User_Like_Film (user_id, film_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 1),
    (2, 2),
    (2, 3),
    (7, 1),
    (6, 2),
    (6, 3),
    (7, 4),
    (4, 5),
    (9, 5),
    (8, 1);

