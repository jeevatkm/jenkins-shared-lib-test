
@Grab('org.apache.commons:commons-lang3:3.8.1')

import org.apache.commons.lang3.StringUtils

def call(Map pipeParams) {
    println 'customPipeline called successfully'

    println StringUtils.isAllUpperCase("ABC")

}