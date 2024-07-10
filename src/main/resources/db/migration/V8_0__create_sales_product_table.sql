CREATE TABLE IF NOT EXISTS "talk"."sales_products" (
    sales_id UUID NOT NULL,
    product_id UUID NOT NULL,
    created_at timestamp not null default now(),
    updated_at timestamp,
    CONSTRAINT fk_sales FOREIGN KEY (sales_id) REFERENCES "talk"."sales"(id),
    CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES "talk"."product"(id),
    PRIMARY KEY (sales_id, product_id)
);
