-- Insert datas
INSERT INTO product (
    code, name, description, image, category, price, quantity, internal_reference, shell_id, inventory_status, rating
) VALUES
(
    'BL001',
    'Moisturizing Body Lotion',
    'Hydrating body lotion for all skin types',
    'body_lotion.jpg',
    'Personal Care',
    15.99,
    100,
    'REFBL001',
    10,
    'INSTOCK',
    4.7
),
(
    'SH001',
    'Anti-Dandruff Shampoo',
    'Soothing shampoo to reduce dandruff and dry scalp',
    'shampoo.jpg',
    'Hair Care',
    12.50,
    80,
    'REFSH001',
    11,
    'INSTOCK',
    4.5
),
(
    'BL002',
    'Shea Butter Body Cream',
    'Rich body cream with shea butter for extra moisture',
    'shea_butter_cream.jpg',
    'Personal Care',
    18.75,
    60,
    'REFBL002',
    12,
    'LOWSTOCK',
    4.8
),
(
    'SH002',
    'Organic Herbal Shampoo',
    'Organic shampoo with herbal extracts for soft, shiny hair',
    'herbal_shampoo.jpg',
    'Hair Care',
    22.00,
    50,
    'REFSH002',
    13,
    'OUTOFSTOCK',
    4.6
),
(
    'BL003',
    'Cocoa Butter Lotion',
    'Fast-absorbing lotion with cocoa butter for dry skin',
    'cocoa_butter_lotion.jpg',
    'Personal Care',
    13.45,
    120,
    'REFBL003',
    14,
    'INSTOCK',
    4.3
),
(
    'SH003',
    'Volumizing Shampoo',
    'Shampoo to add volume and bounce to thin hair',
    'volumizing_shampoo.jpg',
    'Hair Care',
    19.99,
    30,
    'REFSH003',
    15,
    'LOWSTOCK',
    4.2
);