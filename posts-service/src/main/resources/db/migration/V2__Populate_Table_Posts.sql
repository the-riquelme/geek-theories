INSERT INTO
    `posts` (
        `id`,
        `title`,
        `body`,
        `user_id`,
        `status`,
        `created_at`,
        `updated_at`
    )
VALUES (
        '1',
        'Título do post 1',
        'Corpo do post 1',
        '1',
        'Ativo',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ), (
        '2',
        'Título do post 2',
        'Corpo do post 2',
        '2',
        'Inativo',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ), (
        '3',
        'Título do post 3',
        'Corpo do post 3',
        '1',
        'Ativo',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    );