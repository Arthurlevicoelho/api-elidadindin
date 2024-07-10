CREATE TABLE IF NOT EXISTS "talk"."sales" (
    id uuid PRIMARY KEY,
    user_id uuid NOT NULL,
    address_id uuid NOT NULL,
    final_value DOUBLE PRECISION NOT NULL,
    payment "talk"."payment_enum" NOT NULL,
    order_status "talk"."order_enum" NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES "talk"."user"(id),
    CONSTRAINT fk_address FOREIGN KEY (address_id) REFERENCES "talk"."address"(id)
);
