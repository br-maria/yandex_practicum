-- Создание таблицы сенсоров
CREATE TABLE IF NOT EXISTS sensors (
    id SERIAL PRIMARY KEY,
    sensor_id VARCHAR(255) NOT NULL UNIQUE,
    location VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Вставка начальных данных
INSERT INTO sensors (sensor_id, location)
VALUES
('1', 'Living Room'),
('2', 'Bedroom'),
('3', 'Kitchen')
ON CONFLICT DO NOTHING;

