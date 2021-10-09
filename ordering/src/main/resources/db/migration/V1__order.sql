CREATE TABLE IF NOT EXISTS orders
(
  id        BIGSERIAL PRIMARY KEY,
  item_id   BIGINT,
  payer     VARCHAR,
  payment_id BIGINT,
  amount    DECIMAL,
  created_at TIMESTAMP,
  last_updated_at TIMESTAMP
);