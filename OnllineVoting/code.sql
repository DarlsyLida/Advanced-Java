USE onlinevoting;

CREATE TABLE users (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100) NOT NULL,
                       city VARCHAR(100) NOT NULL,
                       mobile VARCHAR(15) NOT NULL,
                       gender VARCHAR(10) NOT NULL,
                       age INT NOT NULL,
                       CONSTRAINT unique_mobile UNIQUE (mobile)

);

CREATE TABLE votes (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       user_id INT NOT NULL,
                       candidate VARCHAR(100) NOT NULL,
                       vote_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       FOREIGN KEY (user_id) REFERENCES users(id),
                       CONSTRAINT unique_user_vote UNIQUE (user_id)
);