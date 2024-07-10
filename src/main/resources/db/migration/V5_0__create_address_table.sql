CREATE TABLE IF NOT EXISTS "talk"."address" (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    street VARCHAR(60),
    city VARCHAR(20),
    number VARCHAR(6),
    created_at timestamp not null default now(),
    updated_at timestamp
);