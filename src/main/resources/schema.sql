CREATE TABLE AccountOperations (
    id INT PRIMARY KEY AUTO_INCREMENT,
    account VARCHAR(100) NOT NULL,
    operation VARCHAR(250) NOT NULL,
    operation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);