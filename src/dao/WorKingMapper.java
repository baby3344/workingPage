package dao;
import entity.Working;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorKingMapper {
    /**
     * 查询所有工作笔记信息
     * @return
     */
    public List<Working> getList();

    /**
     *根据工作笔记标签查询记录数
     * @return
     */
    public int getCount(@Param("title") String title);

    /**
     * 获取总记录数
     * @return
     */
    public int getTotalCount();

    /**
     * 根据编号查询工作笔记信息
     * @return
     */
    public Working getWorking(@Param("id") Integer id);

    /**
     *新增记录数
     * @return
     */
    public int save(Working w);

    /**
     * 查询所有工作笔记信息
     * @return
     */
    public List<Working> getListPage(@Param("beginIndex") int beginIndex,@Param("pageSize") int pageSize);
}
