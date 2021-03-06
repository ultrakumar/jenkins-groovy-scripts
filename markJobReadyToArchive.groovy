def warning='[You can ARCHIVE this Job]' 
def now=new Date() 
 
for (job in hudson.model.Hudson.instance.items) { 
	println "\nName: ${job.name}" 
    Run lastSuccessfulBuild = job.getLastSuccessfulBuild() 
	if (lastSuccessfulBuild != null) { 
		def time = lastSuccessfulBuild.getTimestamp().getTime() 
		if (now.month.equals(time.month)){ 
			println("Project has same month as build"); 
		} else { 
			if (job.description.startsWith(warning)){ 
				println("Description has already been changed"); 
			} else { 
				job.setDescription("${warning}") 
			} 
		} 
	} 
} 
