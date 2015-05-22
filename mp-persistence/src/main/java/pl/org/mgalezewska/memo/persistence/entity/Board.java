package pl.org.mgalezewska.memo.persistence.entity;// default package
// Generated 2015-05-18 20:31:46 by Hibernate Tools 3.6.0


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Board generated by hbm2java
 */
@Entity
@Table(name = "BOARD", schema = "MEMO")
public class Board implements java.io.Serializable {

    private Long boardId;
    private String name;
    private String description;
    private Date dateCreated;
    private Date dateUpdated;
    private Set<Memo> memos = new HashSet<Memo>(0);

    public Board() {
    }

    public Board(Long boardId) {
        this.boardId = boardId;
    }

    public Board(Long boardId, String name, String description, Date dateCreated, Date dateUpdated, Set<Memo> memos) {
        this.boardId = boardId;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateUpdated = dateUpdated;
        this.memos = memos;
    }

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "SEQ_BOARD", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Column(name = "BOARD_ID", unique = true, nullable = false, scale = 0)
    public Long getBoardId() {
        return this.boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }


    @Column(name = "NAME", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "DESCRIPTION", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATED", length = 7)
    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_UPDATED", length = 7)
    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "BOARD_MEMO", schema = "MEMO", joinColumns = {
            @JoinColumn(name = "BOARD_ID", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "MEMO_ID", nullable = false, updatable = false)})
    public Set<Memo> getMemos() {
        return this.memos;
    }

    public void setMemos(Set<Memo> memos) {
        this.memos = memos;
    }


}


