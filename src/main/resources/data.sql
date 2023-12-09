insert into FILLER(id, name) values (1, 'Вода');
insert into FILLER(id, name) values (2, 'Вино');
insert into FILLER(id, name) values (3, 'Молоко');
insert into FILLER(id, name) values (4, 'Ром');

insert into TOBACCO(id, name) values(1, 'Adalya');
insert into TOBACCO(id, name) values(2, 'Fumari');
insert into TOBACCO(id, name) values(3, 'Dark side');

insert into USERS(id, username, password, name, telephone, email, role)
    values('0eb79996-f7a5-47d2-974c-d0348f963fd4', 'User', '$2a$12$JbFmjhINEJtifW7S.tz88..w0EcR90q9DuufEj9pmC/K4TnKhTLt.', 'MrUser', '80003332244', 'userMail@gmail.com', 'USER');
insert into USERS(id, username, password, name, telephone, email, role)
    values('7aee330f-9190-4989-9d74-c7be25a52d29', 'Admin', '$2a$12$4tR0IBUIS/Hv4kfkkoAvo..F4t365458y6knjJhvyXZMz8g3SkqTK', 'MrAdmin', '80003332211', 'AdminMail@gmail.com', 'ADMIN');