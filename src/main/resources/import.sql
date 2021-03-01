INSERT INTO customers (identification_number, identification_type, name, last_name, email, cell_phone_number, address) values ('80211730','CC','Leonardo', 'Davinci', 'davinci@gmail.com', '3177163094', 'cl 78 8d-33');
INSERT INTO customers (identification_number, identification_type, name, last_name, email, cell_phone_number, address) values ('1022958504','CC','Maria', 'Magdalena', 'magdalena@gmail.com', '3177163055', 'cl 78 8d-55');
INSERT INTO customers (identification_number, identification_type, name, last_name, email, cell_phone_number, address) values ('606729','CE','George', 'Burns', 'burns@gmail.com', '3177626543', 'cr 7 7-27');
INSERT INTO accounts (open_date, status, account_type, bank, identification_number) values ('2021-02-23',1,'Cuenta de Ahorros', 'Bancolombia', '80211730');
INSERT INTO accounts (open_date, status, account_type, bank, identification_number) values ('2021-02-23',1,'Cuenta Corriente', 'Bancolombia', '1022958504');
INSERT INTO accounts (open_date, status, account_type, bank, identification_number) values ('2021-02-23',1,'Cuenta de Ahorros', 'Bancolombia', '606729');
INSERT INTO credit_cards (expired_date, cvv, credit_card_type, status, account_number) values ('2024-12-31',1234567,'MasterCard', 1, 1);
INSERT INTO credit_cards (expired_date, cvv, credit_card_type, status, account_number) values ('2023-12-31',1234455,'Visa', 1, 2);
INSERT INTO credit_cards (expired_date, cvv, credit_card_type, status, account_number) values ('2022-12-31',7654321,'Visa', 1, 3);