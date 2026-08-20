CREATE TYPE expense_frequency AS ENUM ('NONE', 'MONTHLY', 'WEEKLY', 'YEARLY');

CREATE TABLE "user" (
                          id VARCHAR(255) PRIMARY KEY,
                          ref VARCHAR(255) NOT NULL,
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          phone VARCHAR(50)
);

CREATE TABLE cash_flow (
                           id VARCHAR(255) PRIMARY KEY,
                           created_at TIMESTAMPTZ NOT NULL,
                           amount NUMERIC(15, 2) NOT NULL,
                           user_id VARCHAR(255) NOT NULL,
                           CONSTRAINT fk_cash_flow_user FOREIGN KEY (user_id) REFERENCES "user"(id) ON DELETE CASCADE
);

CREATE TABLE donation (
                          id VARCHAR(255) PRIMARY KEY,
                          comment TEXT,
                          CONSTRAINT fk_donation_cash_flow FOREIGN KEY (id) REFERENCES cash_flow(id) ON DELETE CASCADE
);

CREATE TABLE expense (
                         id VARCHAR(255) PRIMARY KEY,
                         reason TEXT NOT NULL,
                         frequency expense_frequency NOT NULL,
                         CONSTRAINT fk_expense_cash_flow FOREIGN KEY (id) REFERENCES cash_flow(id) ON DELETE CASCADE
);