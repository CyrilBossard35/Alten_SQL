DROP TABLE IF EXISTS product CASCADE;

CREATE TABLE product (
    id uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    image VARCHAR(255),
    category VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    internal_reference VARCHAR(255),
    shell_id INT,
    inventory_status VARCHAR(20) CHECK (inventory_status IN ('INSTOCK', 'LOWSTOCK', 'OUTOFSTOCK')),
    rating DECIMAL(4, 2),  -- Ensured this line is correct
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);