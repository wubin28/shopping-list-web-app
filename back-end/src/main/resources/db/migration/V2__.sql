ALTER TABLE shopping_item
    ADD item VARCHAR(255);

ALTER TABLE shopping_item
    ALTER COLUMN item SET NOT NULL;

ALTER TABLE shopping_item
DROP
COLUMN title;