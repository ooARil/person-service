set search_path to medical;

-- Написать запрос, выводящий первые 50% записей из таблицы
-- (первые значит те где наименьший id)
select *
from contact as c
order by c.id
limit (select count(*)
       from contact) * 0.5