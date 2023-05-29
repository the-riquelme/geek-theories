CREATE TABLE
    `posts` (
        `id` varchar(255) PRIMARY KEY,
        `title` varchar(255),
        `body` text,
        `user_id` varchar(255),
        `status` varchar(255),
        `created_at` timestamp,
        `updated_at` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    ) ENGINE = InnoDB DEFAULT CHARSET = latin1;