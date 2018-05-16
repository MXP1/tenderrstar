package xpmxp1.tenderstar.database.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import xpmxp1.tenderstar.app_objects.Tag;


/**
 * Created by sebastian on 4/21/18.
 */

@Dao
public interface TagDAO {
    @Insert
    public long insertTag(Tag tag);

    @Update
    public void updateTag(Tag tag);

    @Delete
    public void deleteTag(Tag tag);

    @Query("DELETE FROM Tag")
    public void nukeTable();

    @Query("SELECT * FROM Tag")
    public List<Tag> getAllTags();
}
