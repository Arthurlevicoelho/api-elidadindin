CREATE TABLE IF NOT EXISTS "talk"."product" (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    flavor varchar(30) unique not null,
    image BYTEA,
    price DOUBLE PRECISION not null,
    available_quantity INTEGER,
    description varchar(100) not null,
    created_at timestamp not null default now(),
    updated_at timestamp
)