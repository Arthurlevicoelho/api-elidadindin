CREATE TABLE IF NOT EXISTS "talk"."user" (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    first_name varchar(30) unique not null,
    number varchar(13) not null,
    address varchar(100),
    created_at timestamp not null default now(),
    updated_at timestamp
)