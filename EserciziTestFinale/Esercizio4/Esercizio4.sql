USE sakila;

-- QUERY 1 -- 
SELECT 
film.FILM_ID AS CodiceFilm, 
film.TITLE AS TitoloFilm,
film.RELEASE_YEAR AS AnnoRilascio
FROM
film
WHERE
film.RELEASE_YEAR > 2005
ORDER BY
film.TITLE;

-- QUERY 2 --
SELECT
  customer.customer_id      AS CodiceCliente,
  customer.first_name       AS Nome,
  customer.last_name        AS Cognome,
  COUNT(rental.rental_id) AS TotaleNoleggi
FROM customer 
INNER JOIN rental 
  ON customer.customer_id = rental.customer_id
WHERE
  customer.first_name = 'Mary'
  AND customer.last_name  = 'Smith'
GROUP BY
  customer.customer_id,
  customer.first_name,
  customer.last_name;

-- QUERY 3 --
SELECT
film.film_id AS CodiceFilm,
film.title AS TitoloFilm,
COUNT(rental.rental_id) AS TotaleNoleggio
FROM
film
INNER JOIN
inventory
ON 
film.film_id = inventory.film_id
INNER JOIN
rental
ON 
inventory.inventory_id = rental.inventory_id
GROUP BY
film.film_id,
film.title
ORDER BY
TotaleNoleggio DESC;

-- QUERY 4 --
SELECT
film.film_id AS CodiceFilm,
film.title AS TitoloFilm
FROM
film
LEFT JOIN
inventory
ON
film.film_id = inventory.film_id
LEFT JOIN
rental
ON 
inventory.inventory_id = rental.inventory_id
WHERE 
rental.rental_id IS NULL
GROUP BY
film.film_id;

-- QUERY 5--
SELECT 
category.category_id AS CodiceCategoria,
category.name AS NomeCategoria,
COUNT(rental.rental_id) AS TotaleNoleggi
FROM 
category
INNER JOIN
film_category
ON
category.category_id = film_category.category_id
INNER JOIN
film
ON
film_category.film_Id = film.film_id
INNER JOIN
inventory
ON
film.film_Id = inventory.film_Id
INNER JOIN
rental
ON
inventory.inventory_id = rental.inventory_id
GROUP BY
category.category_id,
category.name
ORDER BY
TotaleNoleggi DESC
LIMIT 1;


