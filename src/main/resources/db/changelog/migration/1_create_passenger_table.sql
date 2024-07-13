CREATE TABLE IF NOT EXISTS passenger
(
    id                      BIGSERIAL PRIMARY KEY,
    survived                BOOLEAN      NOT NULL,
    pclass                  VARCHAR(255) NOT NULL,
    name                    VARCHAR(255) NOT NULL,
    sex                     VARCHAR(10)  NOT NULL,
    age                     DOUBLE PRECISION,
    siblings_spouses_aboard INTEGER,
    parents_children_aboard INTEGER,
    fare                    DOUBLE PRECISION
);
