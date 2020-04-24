package kr.ac.mjc.chanyoung.myapp.student.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.ac.mjc.chanyoung.myapp.comon.dao.DataAccessException;
import kr.ac.mjc.chanyoung.myapp.comon.dao.DbUtils;
import kr.ac.mjc.chanyoung.myapp.comon.dao.RowMapper;

/**
 * DbUtils를 사용한 Dao
 * 
 * @author Jacob
 */
public class StudentDao {

	private final String LIST_STUDENTS = "select id, name, dept from student order by id desc";
	private final String GET_STUDENT = "select id, name, dept from student where id=?";
	private final String ADD_STUDENT = "insert student(id,name,dept) values(?,?,?)";
	private final String UPDATE_STUDENT = "update student set name=?, dept=? where id=?";
	private final String DELETE_STUDENT = "delete from student where id=?";

	private DbUtils dbUtils = null;

	public StudentDao() {
		try {
			// Connection pool data source
			DataSource ds = (DataSource) new InitialContext()
					.lookup("java:comp/env/jdbc/jdbc");
			this.dbUtils = new DbUtils(ds);
		} catch (NamingException e) {
			throw new DataAccessException(e);
		}
	}

	public List<Student> listStudents() {
		// Functional interface를 anonymous class로 구현
		RowMapper<Student> mapper = new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs) throws SQLException {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setDept(rs.getString("dept"));
				return student;
			}
		};
		return dbUtils.list(LIST_STUDENTS, mapper);
	}

	public Student getStudent(String id) {
		// Functional interface의 구현체를 lambda expression으로 표현
		return dbUtils.get(GET_STUDENT, (rs) -> {
			Student student = new Student();
			student.setId(rs.getString("id"));
			student.setName(rs.getString("name"));
			student.setDept(rs.getString("dept"));
			return student;
		}, id);
	}

	public int addStudent(Student student) {
		return dbUtils.update(ADD_STUDENT, student.getId(), student.getName(),
				student.getDept());
	}

	public int updateStudent(Student student) {
		return dbUtils.update(UPDATE_STUDENT, student.getName(),
				student.getDept(), student.getId());
	}

	public int deleteStudent(String id) {
		return dbUtils.update(DELETE_STUDENT, id);
	}
}