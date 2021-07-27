package com.imooc.service;

import com.imooc.pojo.Stu;

public interface StuService {
    /**
     * 查询
     * @param id
     * @return
     */
    public Stu getStuInfo(Integer id);

    /**
     * 保存
     * @return
     */
    public void saveStu();

    /**
     * 更新
     * @param id
     * @return
     */
    public void updateStu(int id);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteStu(int id);

    void saveParent();

    void saveChildren();
}
