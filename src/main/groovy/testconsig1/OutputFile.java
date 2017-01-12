package testconsig1;

public class OutputFile {

	private String genelist;
	private String genesize;
	private String genesym;
	private String entrid;
	private String ingenelist;
	private String rawscore;
	private String penalscore;
	private String score;
	private String concepts;
	private String numcon;
	private String timesec;
	
	public OutputFile(String genelist, String genesize, String genesym, String entrid, String ingenelist,
			String rawscore, String penalscore, String score, String concepts, String numcon, String timesec) {
		super();
		this.genelist = genelist;
		this.genesize = genesize;
		this.genesym = genesym;
		this.entrid = entrid;
		this.ingenelist = ingenelist;
		this.rawscore = rawscore;
		this.penalscore = penalscore;
		this.score = score;
		this.concepts = concepts;
		this.numcon = numcon;
		this.timesec = timesec;
	}
	public String getGenelist() {
		return genelist;
	}
	public void setGenelist(String genelist) {
		this.genelist = genelist;
	}
	public String getGenesize() {
		return genesize;
	}
	public void setGenesize(String genesize) {
		this.genesize = genesize;
	}
	public String getGenesym() {
		return genesym;
	}
	public void setGenesym(String genesym) {
		this.genesym = genesym;
	}
	public String getEntrid() {
		return entrid;
	}
	public void setEntrid(String entrid) {
		this.entrid = entrid;
	}
	public String getIngenelist() {
		return ingenelist;
	}
	public void setIngenelist(String ingenelist) {
		this.ingenelist = ingenelist;
	}
	public String getRawscore() {
		return rawscore;
	}
	public void setRawscore(String rawscore) {
		this.rawscore = rawscore;
	}
	public String getPenalscore() {
		return penalscore;
	}
	public void setPenalscore(String penalscore) {
		this.penalscore = penalscore;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getConcepts() {
		return concepts;
	}
	public void setConcepts(String concepts) {
		this.concepts = concepts;
	}
	public String getNumcon() {
		return numcon;
	}
	public void setNumcon(String numcon) {
		this.numcon = numcon;
	}
	public String getTimesec() {
		return timesec;
	}
	public void setTimesec(String timesec) {
		this.timesec = timesec;
	}
	
	
	
	
}
