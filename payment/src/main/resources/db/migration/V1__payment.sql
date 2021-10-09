create table payment
(
    id              BIGSERIAL,
    payment_mode    VARCHAR(20),
    payment_status  VARCHAR (20),
    description     VARCHAR (50),
    amount          DECIMAL
);