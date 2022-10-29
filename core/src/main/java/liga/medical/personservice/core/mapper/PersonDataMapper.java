package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.pojo.PersonData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonDataMapper {

    @Insert("insert into person_data " +
            "values(#{id},#{lastName},#{firstName},#{birthDt}," +
            "#{age},#{sex},#{contactId},#{medicalCardId},#{parentId})")
    long save(PersonData entity);

    @Select("select * from person_data where id=#{id}")
    PersonData findById(@Param("id") Long id);

    @Select("select * from person_data;")
    List<PersonData> findAll();

    @Delete("delete from person_data where id=#{id};")
    void deleteById(@Param("id") Long id);
}
