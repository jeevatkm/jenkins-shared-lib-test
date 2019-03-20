
@Grab('org.apache.commons:commons-lang3:3.8.1')
@Grab('software.amazon.awssdk:cloudformation:2.5.11')

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.mutable.MutableObject

import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.cloudformation.CloudFormationClient

def call(Map pipeParams) {
    println 'customPipeline called successfully'

    println StringUtils.isAllUpperCase("ABC")

    def mutableObject = new MutableObject("Initial value");
    println mutableObject

    def client = CloudFormationClient.bulider().region(Region.of('us-west-1')).build()
    println client
}