CREATE TABLE IF NOT EXISTS "talk"."user_address" (
 	user_id uuid REFERENCES "talk"."user"(id),
 	address_id uuid REFERENCES "talk"."address"(id),
 	PRIMARY KEY (user_id, address_id)
 );
