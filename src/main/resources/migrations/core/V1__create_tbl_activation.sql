CREATE TABLE Activation
(
    id       bigint IDENTITY (1, 1) NOT NULL,
    version  bigint,
    username varchar(255),
    email    varchar(255),
    hash     varchar(255),
    date     date,
    CONSTRAINT pk_activation PRIMARY KEY (id)
)
    GO