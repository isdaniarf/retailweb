INSERT INTO USER (name, type, registered_date)
VALUES ('John', 'EMPLOYEE', '2016-02-02');
INSERT INTO USER (name, type, registered_date)
VALUES ('Mark', 'AFFILIATE', '2016-02-02');
INSERT INTO USER (name, type, registered_date)
VALUES ('Tony', 'CUSTOMER', '2014-02-02');
INSERT INTO USER (name, type, registered_date)
VALUES ('Jeff', 'CUSTOMER', '2016-02-02');

INSERT INTO ITEM (name, price, type)
VALUES ('Chair', 100.0, 'NON_GROCERY');
INSERT INTO ITEM (name, price, type)
VALUES ('Cabinet', 600.0, 'NON_GROCERY');
INSERT INTO ITEM (name, price, type)
VALUES ('Bed', 700.0, 'NON_GROCERY');
INSERT INTO ITEM (name, price, type)
VALUES ('Milk', 3.0, 'GROCERY');
INSERT INTO ITEM (name, price, type)
VALUES ('Cheese', 10.0, 'GROCERY');

INSERT INTO DISCOUNT_SCHEME (code, type, discount)
VALUES ('USER_CUSTOMER_2_YEARS', 'PERCENTAGE', 0.05);
INSERT INTO DISCOUNT_SCHEME (code, type, discount)
VALUES ('USER_AFFILIATE', 'PERCENTAGE', 0.1);
INSERT INTO DISCOUNT_SCHEME (code, type, discount)
VALUES ('USER_EMPLOYEE', 'PERCENTAGE', 0.3);
INSERT INTO DISCOUNT_SCHEME (code, type, discount)
VALUES ('PER_100_DOLLAR', 'DOLLAR', 5);